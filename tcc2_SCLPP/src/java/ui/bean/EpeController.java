package ui.bean;

import entities.Epe;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "epeController")
@ViewScoped
public class EpeController extends AbstractController<Epe> {

    @Inject
    private TipoEquipamentoController tipoEquipamentoCollectionController;

    public EpeController() {
        // Inform the Abstract parent controller of the concrete Epe?cap_first Entity
        super(Epe.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of TipoEquipamento entities
     * that are retrieved from Epe?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for TipoEquipamento page
     */
    public String navigateTipoEquipamentoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TipoEquipamento_items", this.getSelected().getTipoEquipamentoCollection());
        }
        return "/entity/tipoEquipamento/index";
    }

}
