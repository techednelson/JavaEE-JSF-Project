package controller;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;


import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;


@Named
@FacesConfig(version = JSF_2_3)
@ApplicationScoped
public class LanguageController implements Serializable {

    private static final long serialVersionUID = 1L;

    private String locale;

    private static Map<String,Object> countries;
    static{
        countries = new LinkedHashMap<>();
        countries.put("English", Locale.ENGLISH); //label, value
        Locale spanish = new Locale("es");
        countries.put("Spanish", spanish);
    }

    public Map<String, Object> getCountriesInMap() {
        return countries;
    }


    public String getLocale() {
        return locale;
    }


    public void setLocale(String locale) {
        this.locale = locale;
    }


    public void changeLanguage(ValueChangeEvent e){

        String newLocaleValue = e.getNewValue().toString();

        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if(entry.getValue().toString().equals(newLocaleValue)){

                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale((Locale)entry.getValue());
            }
        }

    }

}
