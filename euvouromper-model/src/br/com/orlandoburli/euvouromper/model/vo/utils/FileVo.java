package br.com.orlandoburli.euvouromper.model.vo.utils;

import java.math.BigDecimal;
import java.util.Calendar;

public class FileVo {

	private String fileName;

	private String fullFileName;

	private String webPath;

	private Calendar lastModification;

	private BigDecimal size;

	private String extension;

	private Integer width;

	private Integer height;

	public String getLongSize() {
		if (getSize() == null) {
			return "";
		}

		BigDecimal d1024 = new BigDecimal(1024);

		BigDecimal newSize = getSize();

		String extension = "bytes";

		// Divide por 1024, Kb
		if (newSize.compareTo(d1024) >= 0) {
			newSize = newSize.divide(d1024);
			extension = "kb";
		}

		// Divide por 1024, Mb
		if (newSize.compareTo(d1024) >= 0) {
			newSize = newSize.divide(d1024);
			extension = "mb";
		}

		// Divide por 1024, Gb
		if (newSize.compareTo(d1024) >= 0) {
			newSize = newSize.divide(d1024);
			extension = "Gb";
		}

		return newSize.intValue() + " " + extension;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFullFileName() {
		return fullFileName;
	}

	public void setFullFileName(String fullFileName) {
		this.fullFileName = fullFileName;
	}

	public Calendar getLastModification() {
		return lastModification;
	}

	public void setLastModification(Calendar lastModification) {
		this.lastModification = lastModification;
	}

	public BigDecimal getSize() {
		return size;
	}

	public void setSize(BigDecimal size) {
		if (size != null) {
			size.setScale(3, BigDecimal.ROUND_CEILING);
		}

		this.size = size;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getWebPath() {
		return webPath;
	}

	public void setWebPath(String webPath) {
		this.webPath = webPath;
	}
}
