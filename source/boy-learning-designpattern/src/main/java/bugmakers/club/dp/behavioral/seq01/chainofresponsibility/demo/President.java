package bugmakers.club.dp.behavioral.seq01.chainofresponsibility.demo;

import java.text.MessageFormat;

/**
 * @Description: 董事长类：具体处理者
 * @Author: Bruce
 * @Datetime: 2018/3/15 20:37
 */
public class President extends Approver {

    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount() < 500000){
            System.out.println(MessageFormat.format("董事长{0}审批采购单：{1}，金额：{2}元，采购目的：{3}。", this.name, request.getNumber(), request.getAmount(), request.getPurpose()));
        }else{
            this.successor.processRequest(request);
        }
    }
}
