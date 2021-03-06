/**
 * 
 */
package com.jspmyadmin.app.server.common.controllers;

import java.sql.SQLException;

import org.json.JSONException;

import com.jspmyadmin.app.server.common.beans.CommonListBean;
import com.jspmyadmin.app.server.common.logic.EngineLogic;
import com.jspmyadmin.framework.constants.AppConstants;
import com.jspmyadmin.framework.exception.EncodingException;
import com.jspmyadmin.framework.web.annotations.Detect;
import com.jspmyadmin.framework.web.annotations.HandleGetOrPost;
import com.jspmyadmin.framework.web.annotations.Model;
import com.jspmyadmin.framework.web.annotations.WebController;
import com.jspmyadmin.framework.web.logic.EncodeHelper;
import com.jspmyadmin.framework.web.utils.RequestLevel;
import com.jspmyadmin.framework.web.utils.View;
import com.jspmyadmin.framework.web.utils.ViewType;

/**
 * @author Yugandhar Gangu
 * @created_at 2016/02/10
 *
 */
@WebController(authentication = true, path = "/server_engines.html", requestLevel = RequestLevel.SERVER)
public class EngineController {

	@Detect
	private EncodeHelper encodeObj;
	@Detect
	private View view;
	@Model
	private CommonListBean bean;

	@HandleGetOrPost
	private void engines() throws SQLException, JSONException, EncodingException {
		EngineLogic engineLogic = new EngineLogic();
		engineLogic.setEncodeObj(encodeObj);
		engineLogic.fillBean(bean);
		view.setType(ViewType.FORWARD);
		view.setPath(AppConstants.JSP_SERVER_COMMON_ENGINELIST);
	}

}
