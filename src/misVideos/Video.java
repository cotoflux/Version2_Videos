package misVideos;
import java.util.ArrayList;
import java.util.List;

public class Video {
	
	private String url;
	private String title;
	private String userName;
	private List<String> listaTaggs ;

	
	public Video(String userName, String url, String title){
		this.userName=userName;
		this.url = url;
		this.title = title;
		this.listaTaggs = new ArrayList<String>();
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public List<String> getListaTaggs() {
		return listaTaggs;
	}


	public void setListaTaggs(List<String> listaTaggs) {
		this.listaTaggs = listaTaggs;
	}
	
	public void addTagg(String Tagg) {
		this.listaTaggs.add(Tagg);
	}



	@Override
	public String toString() {
		return "Video [url=" + url + ", title=" + title + ", userName=" + userName + ", listaTaggs=" + listaTaggs + "]";
	}



	public static void setListVideosForUser(Video creaUnVideo) {
		// TODO Auto-generated method stub
		
	}


}
