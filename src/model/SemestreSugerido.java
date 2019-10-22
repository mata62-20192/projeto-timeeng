package model;

import java.util.ArrayList;
import java.util.List;

public class SemestreSugerido {
	
	private List<CursoDisciplinaObrigatoria> obrigatorias = new ArrayList<>();

	public SemestreSugerido() {
		
	}

	public SemestreSugerido(List<CursoDisciplinaObrigatoria> obrigatorias) {
		
		this.obrigatorias = obrigatorias;
	}

	public List<CursoDisciplinaObrigatoria> getObrigatorias() {
		return obrigatorias;
	}

	public void setObrigatorias(List<CursoDisciplinaObrigatoria> obrigatorias) {
		this.obrigatorias = obrigatorias;
	}
	
}
