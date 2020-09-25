import React, { Component } from 'react';
import imgURL from '../assets/product_image_placeholder.png';
import '../styles/shopItem.scss';

class ShopItem extends Component {
  render() {
    return (
      <div className="shopitem">
        <h3>{this.props.name}</h3>
        <img src={imgURL}></img>
        <h4>{this.props.price}</h4>
        <button onClick={this.props.buyItem}>Add to Cart</button>
      </div>
    );
  }
}

export default ShopItem;