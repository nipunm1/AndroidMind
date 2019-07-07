package com.cmpundhir.cm.allwidgetsdemo.RecyclerView_package;

public class LanguageDetails {
String name;
String desc;

    @Override
    public String toString() {
        return "LanguageDetails{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", logo=" + logo +
                '}';
    }

    public LanguageDetails(final String name, final String desc, final int logo) {
        this.name = name;
        this.desc = desc;
        this.logo = logo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String desc) {
        this.desc = desc;
    }

    public int getLogo() {
        return this.logo;
    }

    public void setLogo(final int logo) {
        this.logo = logo;
    }

    int logo;
}
