package ui.bean;

import entities.Composproduto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "composprodutoController")
@ViewScoped
public class ComposprodutoController extends AbstractController<Composproduto> {

    @Inject
    private ProdutoController produtoCollectionController;

    public ComposprodutoController() {
        // Inform the Abstract parent controller of the concrete Composproduto?cap_first Entity
        super(Composproduto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Produto entities that are
     * retrieved from Composproduto?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Produto page
     */
    public String navigateProdutoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Produto_items", this.getSelected().getProdutoCollection());
        }
        return "/entity/produto/index";
    }

}
