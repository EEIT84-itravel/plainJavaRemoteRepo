package _00_Misc;

import java.io.Serializable;

public class CodeVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String codeId;
	private String codeName;

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	@Override
	public String toString() {
		return "codeVO [codeId=" + codeId + ", codeName=" + codeName + "]";
	}

}
