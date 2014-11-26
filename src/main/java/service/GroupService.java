package service;

import java.util.ArrayList;
import java.util.List;

import model.GroupInfo;
import dao.GroupDao;

public class GroupService {

	public GroupService() {
		// TODO Auto-generated constructor stub
	}
	
	private GroupDao groupDao;
	
	public GroupDao getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	public Integer Create(GroupInfo group){
		return groupDao.Create(group);
	}
	
	public Integer Update(GroupInfo group){
		return groupDao.Update(group);
	}
	
	public List<GroupInfo> Read(){
		List<GroupInfo> chanels = new ArrayList<GroupInfo>();
		try{
			chanels = groupDao.Read();
		}catch(Exception e){
		}
		return chanels;
	}
	
	public Integer Delete(GroupInfo group){
		return groupDao.Delete(group);
	}

}
