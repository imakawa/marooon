package blog.service;

import java.util.*;
import blog.data.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author bret@tymitec.com
 * @version beta
 * @since 2015/09/20
 *
 */
public class MenuInfoService {

	@Autowired
	private MenuinfoHome home;
	
	public Menuinfo findById(Integer id) {
		return home.findById(1);
	}
	
//	@Autowired
//	private AccountDao accountDao;
//
//	public Integer Create(Account account) {
//		return accountDao.Create(account);
//	}
//
//	public Integer Update(Account account) {
//		return accountDao.Update(account);
//	}
//
//	public List<Account> Read() {
//		return accountDao.Read();
//	}
//
//	public String getInfoo(String content) {
//		return "asss";
//	}
//
//	public Integer Delete(Account account) {
//		return accountDao.Delete(account);
//	}
//
//	public String getInfo(String content) {
//		return "ReturnValue:" + content;
//	}
}
