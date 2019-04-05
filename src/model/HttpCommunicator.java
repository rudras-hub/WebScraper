package model;

public class HttpCommunicator {

	protected class UriBuilder {
		
		private static final String PREFIX = "www.";
		
		private static final String SUFFIX = ".com";
		
		private String siteAddress;
		
		private String uri; 
		
		public UriBuilder(String baseAddress) {
			
			this.siteAddress = baseAddress;
			this.uri = BuildUri();
		}
		
		
		public String getAddress() {
			
			return this.siteAddress;
		}
		
		public String getUri() {
			
			return this.uri;
		}
		
		private String BuildUri() {
			
			String uriString = null; 
			
			if(siteAddress.isEmpty())
				throw new NullPointerException(); 
			
			if(!siteAddress.contains(PREFIX))
				uriString = PREFIX + siteAddress; 
			
			if(!siteAddress.contains(SUFFIX))
				uriString = siteAddress + SUFFIX;
			
			return uriString;
			
		}

	}

}
