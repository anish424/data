package no.kantega.springandreact;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class STG_CCAR_STATISTICS {

	// "customer_seq" is Oracle sequence name.
	@Id
	String PARTITION_KEY;

	String  SOURCE_DATA_SET, PROD_ID, PRODUCT_GROUP, PRODUCT_LEVEL_1, PRODUCT_LEVEL_2, PRODUCT_LEVEL_3,
			QRM_MAPPED_CATEGORY, STANDARD_OF_REFERENCE_DESC, MANAGEMENT_PRODUCT_DESC;

	public String getPARTITION_KEY() {
		return PARTITION_KEY;
	}

	public void setPARTITION_KEY(String pARTITION_KEY) {
		PARTITION_KEY = pARTITION_KEY;
	}

	public String getSOURCE_DATA_SET() {
		return SOURCE_DATA_SET;
	}

	public void setSOURCE_DATA_SET(String sOURCE_DATA_SET) {
		SOURCE_DATA_SET = sOURCE_DATA_SET;
	}

	public String getPROD_ID() {
		return PROD_ID;
	}

	public void setPROD_ID(String pROD_ID) {
		PROD_ID = pROD_ID;
	}

	public String getPRODUCT_GROUP() {
		return PRODUCT_GROUP;
	}

	public void setPRODUCT_GROUP(String pRODUCT_GROUP) {
		PRODUCT_GROUP = pRODUCT_GROUP;
	}

	public String getPRODUCT_LEVEL_1() {
		return PRODUCT_LEVEL_1;
	}

	public void setPRODUCT_LEVEL_1(String pRODUCT_LEVEL_1) {
		PRODUCT_LEVEL_1 = pRODUCT_LEVEL_1;
	}

	public String getPRODUCT_LEVEL_2() {
		return PRODUCT_LEVEL_2;
	}

	public void setPRODUCT_LEVEL_2(String pRODUCT_LEVEL_2) {
		PRODUCT_LEVEL_2 = pRODUCT_LEVEL_2;
	}

	public String getPRODUCT_LEVEL_3() {
		return PRODUCT_LEVEL_3;
	}

	public void setPRODUCT_LEVEL_3(String pRODUCT_LEVEL_3) {
		PRODUCT_LEVEL_3 = pRODUCT_LEVEL_3;
	}

	public String getQRM_MAPPED_CATEGPRY() {
		return QRM_MAPPED_CATEGORY;
	}

	public void setQRM_MAPPED_CATEGPRY(String qRM_MAPPED_CATEGPRY) {
		QRM_MAPPED_CATEGORY = qRM_MAPPED_CATEGPRY;
	}

	public String getSTANDARD_OF_REFERENCE_DESC() {
		return STANDARD_OF_REFERENCE_DESC;
	}

	public void setSTANDARD_OF_REFERENCE_DESC(String sTANDARD_OF_REFERENCE_DESC) {
		STANDARD_OF_REFERENCE_DESC = sTANDARD_OF_REFERENCE_DESC;
	}

	public String getMANAGEMENT_PRODUCT_DESC() {
		return MANAGEMENT_PRODUCT_DESC;
	}

	public void setMANAGEMENT_PRODUCT_DESC(String mANAGEMENT_PRODUCT_DESC) {
		MANAGEMENT_PRODUCT_DESC = mANAGEMENT_PRODUCT_DESC;
	}

	public STG_CCAR_STATISTICS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public STG_CCAR_STATISTICS(ArrayList<String> row) {
		PARTITION_KEY = row.get(0);
		SOURCE_DATA_SET = row.get(1);
		PROD_ID = row.get(2);
		PRODUCT_GROUP = row.get(3);
		PRODUCT_LEVEL_1 = row.get(4);
		PRODUCT_LEVEL_2 = row.get(5);
		PRODUCT_LEVEL_3 = row.get(6);
		QRM_MAPPED_CATEGORY = row.get(7);
		STANDARD_OF_REFERENCE_DESC = row.get(8);
		MANAGEMENT_PRODUCT_DESC = row.get(9);
	}
}