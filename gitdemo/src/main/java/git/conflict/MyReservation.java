package git.conflict;

import java.util.Date;

public class MyReservation {
	private String requester;
	private Date startDate;
	private Date endDate;

	public String getRequester() {
		System.out.println(requester);
		return requester;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
