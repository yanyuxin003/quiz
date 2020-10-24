import React, {Component} from 'react';
import '../styles/goods.css';
import Order from './orders';

let url = 'http://localhost:8080/orderList';
class Orders extends Component {
    state = {
        data: [],
    }

    componentDidMount() {
        fetch(url, {
            method: 'GET',
        })
            .then((res) => res.json())
            .then((data) => {
                console.log(data)
                this.setState({
                    data: data,
                })
            })
    }

    render() {
        console.log(this.state.data);
        return (
            <div className="orderList">
                <table className="order" align="center">
                    <thead>
                        <tr>
                            <th>订单号</th>
                            <th>删除</th>
                        </tr>
                        <tr>
                            <th>名称</th>
                            <th>单价</th>
                            <th>数量</th>
                        </tr>
                        <tr>
                            总价
                        </tr>
                    </thead>
                    <tbody>
                    {this.state.data.map((item ) =>
                        <tr key={item.id}>
                            <td>{item.name}</td>
                            <td>{item.price}</td>
                            <td>{item.count}/{item.goodunit}</td>
                            {/*<td><button onClick = {this.deleteOrders(item.id)}>删除</button></td>*/}
                        </tr>
                    )}
                    </tbody>
                </table>
            </div>
        )
    }
}
export default Orders;

