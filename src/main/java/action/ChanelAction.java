package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.struts2.StrutsStatics;
import com.opensymphony.xwork2.ActionContext;
import service.ChanelService;
import model.Chanel;

//ChanelAction For SiteUpdate
public class ChanelAction {

	private ChanelService chanelService;
	private List<Chanel> chanels;
	
	public ChanelService getChanelService() {return chanelService;}
	public void setChanelService(ChanelService chanelService) {this.chanelService = chanelService;}
	public List<Chanel> getChanels() {return chanels;}
	public void setChanels(List<Chanel> chanels) {this.chanels = chanels;}

	public String Read() {
		chanels = chanelService.Read();
		return "Success";
	}
	
	public void ReadJson(){
		try {
			List<Chanel> chanels = chanelService.Read();

			ActionContext context = ActionContext.getContext();
			HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
			response.setContentType("application/json;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			PrintWriter pw = response.getWriter();
			String str = JSONArray.fromObject(chanels).toString();
			pw.write(str);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
