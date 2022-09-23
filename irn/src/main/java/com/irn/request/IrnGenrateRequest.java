package com.irn.request;

import java.util.ArrayList;

public class IrnGenrateRequest {

	private String version;

	private TranDtls tranDtls;

	private DocDtls docDtls;

	private SellerDtls sellerDtls;

	private BuyerDtls buyerDtls;

	private DispDtls dispDtls;

	private ShipDtls shipDtls;

	private ArrayList<ItemList> itemList;

	private ValDtls valDtls;

	private PayDtls payDtls;

	private RefDtls refDtls;

	private ArrayList<AddlDocDtls> addlDocDtls;

	private ExpDtls expDtls;

	private EwbDtls ewbDtls;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public TranDtls getTranDtls() {
		return tranDtls;
	}

	public void setTranDtls(TranDtls tranDtls) {
		this.tranDtls = tranDtls;
	}

	public DocDtls getDocDtls() {
		return docDtls;
	}

	public void setDocDtls(DocDtls docDtls) {
		this.docDtls = docDtls;
	}

	public SellerDtls getSellerDtls() {
		return sellerDtls;
	}

	public void setSellerDtls(SellerDtls sellerDtls) {
		this.sellerDtls = sellerDtls;
	}

	public BuyerDtls getBuyerDtls() {
		return buyerDtls;
	}

	public void setBuyerDtls(BuyerDtls buyerDtls) {
		this.buyerDtls = buyerDtls;
	}

	public DispDtls getDispDtls() {
		return dispDtls;
	}

	public void setDispDtls(DispDtls dispDtls) {
		this.dispDtls = dispDtls;
	}

	public ShipDtls getShipDtls() {
		return shipDtls;
	}

	public void setShipDtls(ShipDtls shipDtls) {
		this.shipDtls = shipDtls;
	}

	public ArrayList<ItemList> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemList> itemList) {
		this.itemList = itemList;
	}

	public ValDtls getValDtls() {
		return valDtls;
	}

	public void setValDtls(ValDtls valDtls) {
		this.valDtls = valDtls;
	}

	public PayDtls getPayDtls() {
		return payDtls;
	}

	public void setPayDtls(PayDtls payDtls) {
		this.payDtls = payDtls;
	}

	public RefDtls getRefDtls() {
		return refDtls;
	}

	public void setRefDtls(RefDtls refDtls) {
		this.refDtls = refDtls;
	}

	public ArrayList<AddlDocDtls> getAddlDocDtls() {
		return addlDocDtls;
	}

	public void setAddlDocDtls(ArrayList<AddlDocDtls> addlDocDtls) {
		this.addlDocDtls = addlDocDtls;
	}

	public ExpDtls getExpDtls() {
		return expDtls;
	}

	public void setExpDtls(ExpDtls expDtls) {
		this.expDtls = expDtls;
	}

	public EwbDtls getEwbDtls() {
		return ewbDtls;
	}

	public void setEwbDtls(EwbDtls ewbDtls) {
		this.ewbDtls = ewbDtls;
	}

	@Override
	public String toString() {
		return "IrnGenrate [Version=" + version + ", tranDtls=" + tranDtls + ", docDtls=" + docDtls + ", sellerDtls="
				+ sellerDtls + ", buyerDtls=" + buyerDtls + ", dispDtls=" + dispDtls + ", shipDtls=" + shipDtls
				+ ", itemList=" + itemList + ", valDtls=" + valDtls + ", payDtls=" + payDtls + ", refDtls=" + refDtls
				+ ", addlDocDtls=" + addlDocDtls + ", expDtls=" + expDtls + ", ewbDtls=" + ewbDtls + "]";
	}

}
