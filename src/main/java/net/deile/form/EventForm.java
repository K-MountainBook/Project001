package net.deile.form;

import lombok.Data;

/**
 * イベント登録フォーム用
 * @author k_yamamoto
 *
 */
@Data
public class EventForm {

	private String title;

	private String details;

	private String address;

	private String fromDate;

	private String toDate;

	private String fromTime;

	private String toTime;

	private Integer max_participant;

	private Boolean public_flag;
}
