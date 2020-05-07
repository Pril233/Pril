package com.how2java.tmall.util
import org.springframework.data.domain.Page

class Page4Navigator<T> {
    Page<T> pageFromJPA
    int navigatePages

    int totalPages

    int number

    long totalElements

    int size

    int numberOfElements

    List<T> content

    boolean isHasContent

    boolean first

    boolean last

    boolean isHasNext

    boolean isHasPrevious

    int[] navigatepageNums

    Page4Navigator(){

    }



    int getNavigatePages() {
        return navigatePages
    }

    void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages
    }

    int getTotalPages() {
        return totalPages
    }

    void setTotalPages(int totalPages) {
        this.totalPages = totalPages
    }

    int getNumber() {
        return number
    }

    void setNumber(int number) {
        this.number = number
    }

    long getTotalElements() {
        return totalElements
    }

    void setTotalElements(long totalElements) {
        this.totalElements = totalElements
    }

    int getSize() {
        return size
    }

    void setSize(int size) {
        this.size = size
    }

    int getNumberOfElements() {
        return numberOfElements
    }

    void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements
    }

    List<T> getContent() {
        return content
    }

    void setContent(List<T> content) {
        this.content = content
    }

    boolean getIsHasContent() {
        return isHasContent
    }

    void setIsHasContent(boolean isHasContent) {
        this.isHasContent = isHasContent
    }

    boolean getFirst() {
        return first
    }

    void setFirst(boolean first) {
        this.first = first
    }

    boolean getLast() {
        return last
    }

    void setLast(boolean last) {
        this.last = last
    }

    boolean getIsHasNext() {
        return isHasNext
    }

    void setIsHasNext(boolean isHasNext) {
        this.isHasNext = isHasNext
    }

    boolean getIsHasPrevious() {
        return isHasPrevious
    }

    void setIsHasPrevious(boolean isHasPrevious) {
        this.isHasPrevious = isHasPrevious
    }

    int[] getNavigatepageNums() {
        return navigatepageNums
    }

    void setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums
    }

    Page4Navigator(Page<T> pageFromJPA, int navigatePages){
        this.pageFromJPA = pageFromJPA
        this.navigatePages = navigatePages

        totalPages = pageFromJPA.getTotalPages()

        number = pageFromJPA.getNumber()

        totalElements = pageFromJPA.getTotalElements()

        size = pageFromJPA.getSize()

        numberOfElements = pageFromJPA.getNumberOfElements()

        content = pageFromJPA.getContent()

        isHasContent = pageFromJPA.hasContent()

        first = pageFromJPA.isFirst()

        last = pageFromJPA.isLast()

        isHasNext = pageFromJPA.hasNext()

        isHasPrevious = pageFromJPA.hasPrevious()

        calcNavigatepageNums()
    }

    private void calcNavigatepageNums() {
        int []navigatepageNums;
        int totalPages = getTotalPages();
        int num = getNumber();
        //当总页数小于或等于导航页码数时
        if (totalPages <= navigatePages) {
            navigatepageNums = new int[totalPages];
            for (int i = 0; i < totalPages; i++) {
                navigatepageNums[i] = i + 1;
            }
        } else { //当总页数大于导航页码数时
            navigatepageNums = new int[navigatePages];
            int startNum = num - navigatePages / 2;
            int endNum = num + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                //(最前navigatePages页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            } else if (endNum > totalPages) {
                endNum = totalPages;
                //最后navigatePages页
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatepageNums[i] = endNum--;
                }
            } else {
                //所有中间页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            }
        }
        this.navigatepageNums = navigatepageNums;
    }



    }



