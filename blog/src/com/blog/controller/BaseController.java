package com.blog.controller;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.blog.util.StringUtil;

public class BaseController {
	protected static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(BaseController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// date,datetime
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				if (StringUtil.isEmpty(value)) {
					setValue(null);
					return;
				}
				try {
					if (value.length() == 10) {
						setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
					} else if (value.length() == 8) {
						setValue(new SimpleDateFormat("HH:mm:ss").parse(value));
					} else if (value.length() == 16) {
						setValue(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(value));
					} else {
						setValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value));
					}

				} catch (ParseException e) {
					log.error("Can not convert '" + value + "' to java.util.Date", e);
				}
			}

			public String getAsText() {
				return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) getValue());
			}

		});
		// int
		binder.registerCustomEditor(Integer.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				if (StringUtil.isEmpty(value)) {
					setValue(0);
					return;
				}
				setValue(Integer.parseInt(value));
			}

			public String getAsText() {
				return getValue().toString();
			}

		});

		// long
		binder.registerCustomEditor(Long.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				if (StringUtil.isEmpty(value)) {
					setValue(0);
					return;
				}
				setValue(Long.parseLong(value));
			}

			public String getAsText() {
				return getValue().toString();
			}

		});

		// double
		binder.registerCustomEditor(Double.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				if (StringUtil.isEmpty(value)) {
					setValue(0);
					return;
				}
				setValue(Double.parseDouble(value));
			}

			public String getAsText() {
				return getValue().toString();
			}

		});
	}

}
