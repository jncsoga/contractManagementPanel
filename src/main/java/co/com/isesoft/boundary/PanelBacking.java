package co.com.isesoft.boundary;

import co.com.isesoft.control.InfoApiManagement;
import co.com.isesoft.entity.InfoApi;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PanelBacking implements Serializable {
    @Inject
    private InfoApiManagement infoApiManagement;

    private List<InfoApi> infoApis;

    private List<InfoApi> filteredInfoApis;

    @PostConstruct
    public void init() {this.infoApis = infoApiManagement.findByValidate(Boolean.FALSE);}

    public void loadInfoApi() {
        infoApiManagement.loadClientsApi();
        this.infoApis = infoApiManagement.findByValidate(Boolean.FALSE);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }

    public InfoApiManagement getInfoApiManagement() {
        return infoApiManagement;
    }

    public void setInfoApiManagement(InfoApiManagement infoApiManagement) {
        this.infoApiManagement = infoApiManagement;
    }

    public List<InfoApi> getInfoApis() {
        return infoApis;
    }

    public void setInfoApis(List<InfoApi> infoApis) {
        this.infoApis = infoApis;
    }

    public List<InfoApi> getFilteredInfoApis() {
        return filteredInfoApis;
    }

    public void setFilteredInfoApis(List<InfoApi> filteredInfoApis) {
        this.filteredInfoApis = filteredInfoApis;
    }
}
