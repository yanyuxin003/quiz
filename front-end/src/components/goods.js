import React, {Component} from 'react';
import '../styles/products.css';


class Goods extends Component {
    constructor(props) {
        super(props);
        this.state = {
            product:{
                count:0,
            },
        };
    }




    addProduct = () => {
        this.setState({
            product:{
                name:this.props.name,
                price:this.props.price,
                unit:this.props.unit,
                count:this.state.count + 1
            }
        })
        this.context.router.history.push('/orders', this.state.product);
    }

    render() {
        let url = JSON.stringify(this.props.url);
        console.log(url)
        return (
            <section>
                <img className="image" alt="goodspicture" src={this.props.url} ></img>
                <h2>{this.props.name}</h2>
                <p>单价{this.props.price}元/{this.props.unit}</p>
                <button onChange={this.addProduct}>+</button>
            </section>
        );
    }
}
export default Goods;