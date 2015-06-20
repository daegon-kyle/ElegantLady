/*
	작성자 : 장성봉
	클래스명 : 배송상태 // enum DeliveryState
*/
enum DeliveryState
{
	PREPARATION("물품준비중"),DELIVERING("배송중"),COMPLETION("배송완료");
	final private String deliveryState;
	private DeliveryState(String deliveryState)
	{
		this.deliveryState = deliveryState;
	}
	public String value()
	{
		return this.deliveryState;
	}
}