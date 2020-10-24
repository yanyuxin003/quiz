import React, {Component} from 'react';
import '../styles/goods.css';

class Order extends Component {
    deleteOrder(){

}

    render() {
        return (
            <div className="orderList">
                <div className='content'>
                    <h2>{this.props.order.name}</h2>
                    <h2>{this.props.order.price}</h2>
                    <h2>{this.props.order.number}</h2>
                    <button type="link" danger onClick = {this.deleteOrder}>
                        删除订单
                    </button>
                </div>
            </div>
        );
    };
}

export default Order;