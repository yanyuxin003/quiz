import React, { Component } from 'react';
import imgURL from '../assets/product_image_placeholder.png';
import '../styles/shoppingCart.css';

class ShoppingCart extends Component {
    render() {
        return (
            <div className="shopitem">
                <h2>购物车</h2>
                <h3>名称：{this.props.name}</h3>
                {/*<img src={imgURL}></img>*/}
                <h3>价格：{this.props.price}</h3>
                <h3>数量：{this.props.count}</h3>
            </div>
        );
    }
}

export default ShoppingCart;