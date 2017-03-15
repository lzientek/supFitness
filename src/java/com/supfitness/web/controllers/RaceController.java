package com.supfitness.web.controllers;

import com.supfitness.dao.jpa.JpaRacesDao;
import com.supfitness.entity.Race;
import com.supfitness.helper.PagerClass;
import com.supfitness.service.RaceService;
import com.supfitness.web.controllers.util.JsfUtil;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean
@Named("raceController")
@SessionScoped
public class RaceController extends ControllerHelper {

    private Race current;
    private List<Race> items = null;
    @EJB
    private RaceService raceService;
    private PagerClass pager;

    public RaceController() {
    }

    public Race getSelected() {
        if (current == null) {
            current = new Race();
        }
        return current;
    }

    public PagerClass getPager() {
        return pager;
    }

    public void setPager(PagerClass pager) {
        this.pager = pager;
    }

    public int getActualPage() {
        if (pager == null) {
            return 0;
        } else {
            return pager.getActualPage();
        }
    }

    public void nextPage() {
        pager.next();
        prepareList();
    }

    public void previousPage() {
        pager.previous();
        prepareList();
    }

    public void gotoPage(int page) {
        pager.setActualPage(page);
        prepareList();
    }

    public String prepareList() {
        pager = new PagerClass(raceService.countUsersRaces(getConnectedAccount().getId()), JpaRacesDao.OBJECT_PER_PAGE, getActualPage());
        items = raceService.getAllObjectsFromUser(getActualPage(), getConnectedAccount().getId());
        return getPath() + "race/List.xhtml";
    }

    public String prepareView(Long id) {
        current = raceService.find(id);
        return "View";
    }

    public String prepareCreate() {
        current = new Race();
        return "Create";
    }

    public String create() {
        try {
            raceService.createRace(current);
            JsfUtil.addSuccessMessage(getBundle().getString("RaceCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, getBundle().getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        return "Edit";
    }

    public String update() {
        try {
            raceService.edit(current);
            JsfUtil.addSuccessMessage(getBundle().getString("RaceUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, getBundle().getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public List<Race> getItems() {
        if (items == null) {
            prepareList();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    public Race getRace(java.lang.Long id) {
        return raceService.find(id);
    }

    @FacesConverter(forClass = Race.class)
    public static class RaceControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RaceController controller = (RaceController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "raceController");
            return controller.getRace(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Race) {
                Race o = (Race) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Race.class.getName());
            }
        }

    }

}
