package dataresources.datacomponents;

public enum FileExtensions {
	
	IMAGE_EXTENSION(new String[] { ".png", ".jpg", ".jpeg", ".ico", ".bmp", ".gif", ".yup"});	
	
	private String[] extensions;
	
	FileExtensions (String[] extensions){
		this.extensions = extensions;
	}
	
	public String[] getExtensions() {
		return extensions;
	}
}
