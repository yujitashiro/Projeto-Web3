/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.web3.controllers;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jorge
 */
@FacesConverter("upperCaseConverter")
public class ToUpperCaseConverter implements Converter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (value != null) ? value.toString().toUpperCase() : null;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return (string != null) ? string.toUpperCase() : null;
    }
}
