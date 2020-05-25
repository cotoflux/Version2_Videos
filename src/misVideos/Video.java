package misVideos;
import java.util.ArrayList;
import java.util.List;

public class Video {
	
	private String url;
	private String title;
	private List<Tagg> listaTaggs = new ArrayList<Tagg>();

	
	public Video(String url, String title, List<Tagg> listaTaggs){
		this.url = url;
		this.title = title;
		this.listaTaggs = listaTaggs;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public List<Tagg> getListaTaggs() {
		return listaTaggs;
	}


	public void setListaTaggs(List<Tagg> listaTaggs) {
		this.listaTaggs = listaTaggs;
	}

	
}
