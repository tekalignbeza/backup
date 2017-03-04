/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mybot.domain.search;

import java.util.List;

/**
 *
 * @author teke
 */
public class WebSearchRequest {
    String keyword;
    String url;
    List<String> preference;
    
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getPreference() {
        return preference;
    }

    public void setPreference(List<String> preference) {
        this.preference = preference;
    }
    
}
