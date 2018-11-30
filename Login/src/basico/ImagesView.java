package basico;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ImagesView {
	private List<String> images;
	private String option;
	
    
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        livrosAutoAjuda();
        livrosMitologia();
        livrosFiccao();
        
    }

	private void livrosAutoAjuda() {
		for (int i = 1; i <= 2; i++) {
            images.add("AutoAjuda" + i + ".jpg");
        }
	}
	
	private void livrosMitologia() {
		for (int i = 1; i <= 1; i++) {
            images.add("Mitologia" + i + ".jpg");
        }
	}
	
	private void livrosFiccao() {
		for (int i = 1; i <= 1; i++) {
            images.add("Ficcao" + i + ".jpg");
        }
	}
 
    public List<String> getImages() {
        return images;
    }

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
		String mensagem = "";
		if (option != null && !option.equals("")) {
			images = new ArrayList<String>();
		if (option.equals("AutoAjuda")) {
			livrosAutoAjuda();
		} else if (option.equals("Ficcao")) {
			livrosFiccao();
		} else if (option.equals("Mitologia")) {
			livrosMitologia();
		}
		mensagem = "plataforma selecionada com sucesso";
		} else {
		mensagem = "Todas as plataformas selecionadas";
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", mensagem));
		}
	}