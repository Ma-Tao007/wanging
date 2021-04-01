package com.po;


public class Drug {
	  private Integer id;

	    private String drugname;

	    private Double price;

	    private Integer num;

	    private String inputtime;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getDrugname() {
			return drugname;
		}

		public void setDrugname(String drugname) {
			this.drugname = drugname;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Integer getNum() {
			return num;
		}

		public void setNum(Integer num) {
			this.num = num;
		}

		public String getInputtime() {
			return inputtime;
		}

		public void setInputtime(String inputtime) {
			this.inputtime = inputtime;
		}
}
