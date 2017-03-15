/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfitness.helper;

/**
 *
 * @author 15256
 */
public class PagerClass {

    private int numberOfPage;
    private int actualPage;
    private Boolean isFirstPage;
    private Boolean isLastPage;

    public PagerClass(Long numberOfResult, int resultPerPage, int actualPage) {
        this.actualPage = actualPage;
        isFirstPage = actualPage == 0;
        numberOfPage = (int) Math.ceil(numberOfResult / (double) resultPerPage);
        numberOfPage = numberOfPage == 0 ? 1 : numberOfPage; // avoid errors we need at least 1 page
        isLastPage = actualPage + 1 >= numberOfPage;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public int getActualPage() {
        return actualPage;
    }

    public void setActualPage(int actualPage) {
        this.actualPage = actualPage;
    }

    public Boolean getIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(Boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public Boolean getIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(Boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public void next() {
        if (!isLastPage) {
            actualPage++;
        }
    }

    public void previous() {
        if (!isFirstPage) {
            actualPage--;
        }
    }

}
