package br.com.netflics.core.rs;

import java.io.Serializable;
/* generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21 */
public class DataUpload implements Serializable {

	private String dataType;
	private String dataUrl;

	public DataUpload(String dataType, String dataUrl) {
		super();
		this.dataType = dataType;
		this.dataUrl = dataUrl;
	}

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
