/*
	�ۼ��� : �强��
	Ŭ������ : ��ۻ��� // enum DeliveryState
*/
enum DeliveryState
{
	PREPARATION("��ǰ�غ���"),DELIVERING("�����"),COMPLETION("��ۿϷ�");
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