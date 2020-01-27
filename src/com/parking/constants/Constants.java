package com.parking.constants;


public interface Constants {

	public enum Commands {
		PARK_CAR("Park Car");

		private String type;

		private Commands(String type) {
			this.type = type;
		}
		
		public static Commands getAccountType(String name) {
			if(null==name|| name.isEmpty()) {
				return null;
			}
			for(Commands ele: Commands.values()) {
				if(ele.getName().equalsIgnoreCase(name)|| ele.getType().equalsIgnoreCase(name)) {
					return ele;
				}
			}
			return null;
		}

		public static Boolean validateAccountType(String account) {
			if (null == account || account.isEmpty()) {
				return false;
			}
			for (AccountType ele : AccountType.values()) {
				if (ele.getName().equalsIgnoreCase(account)) {
					return true;
				}
			}
			return false;
		}
	}


}
