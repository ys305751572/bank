package com.sixmac.core;

/**
 * Created by wangbin on 2015/9/28.
 */
public enum  OrderStatus {

    CANCEL(0),//ȡ������
    UN_PAY(1),//������
    ALREADY_PAY(2),//�Ѹ���
    UN_SEND(3),//������
    ALREADY_SEND(4),//�ѷ���
    FINISH(5);//���

    private Integer status;

    OrderStatus(Integer status){
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }


    public static Integer getValue(String name){
        for(OrderStatus eventType : OrderStatus.values()) {
            if(eventType.name().equals(name)){
                return eventType.getStatus();
            }
        }
        return null;
    }

    public static String getText(Integer status){

        String text ="";
        switch (status){
            case 0:
                text="ȡ������";
                break;
            case 1:
                text="������";
                break;
            case 2:
                text="�Ѹ���";
                break;
            case 3:
                text="������";
                break;
            case 4:
                text="�ѷ���";
                break;
            case 5:
                text="�����";
                break;
            default:
                text="ȡ������";
        }

        return text;

    }

}
