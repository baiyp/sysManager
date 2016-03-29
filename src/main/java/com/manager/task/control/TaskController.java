/**
 * 
 */
package com.manager.task.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.common.view.PageView;
import com.manager.control.base.BaseController;
import com.manager.sys.model.Task;
import com.manager.task.service.TaskService;

/**
 * @author baiyp
 *
 */
@Controller
public class TaskController extends BaseController {
	
	
	@Autowired
	private TaskService taskService;

	/**
	 * 
	 */
	public TaskController() {
	}
	
	
	@RequestMapping(value="/taskManage")
	@ResponseBody
	public PageView<Task> queryTaskManage(HttpServletRequest request,HttpServletResponse response){
		PageView<Task> page = new PageView<Task>();
		return page;
	}
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
