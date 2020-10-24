import React, {Component} from 'react';
import Goods from './goods';
import '../styles/home.css';
import ShoppingCart from "./shoppingCart";
import { Modal, Button } from 'antd';

let url = 'http://localhost:8080/goods';

class Home extends Component {
    constructor(props) {
        super(props)
        this.state = {
           data:[],
           visible: false
        }
    }

    getInitialState() {
        return { visible: false };
    }

    showModal() {
        this.setState({
            visible: true,
        });
    }

    handleOk() {
        this.setState({
            visible: false,
        });
    }

    handleCancel() {
        this.setState({
            visible: false,
        });
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

    render()
        {
            return (
                <div>
                    <div className='goodsList'>{
                        this.state.data.map(good=>(
                            <Goods key ={good.name}
                                   good ={good}/>
                        ))
                    }
                    </div>
                    <Button className="shopitem" onClick = {this.showModal}>Cart</Button>
                    <Modal title="Modal" visible={this.state.visible}
                           onOk={this.handleOk} onCancel={this.handleCancel}
                           okText="OK" cancelText="Cancel"
                    >
                        <p>Bla bla ...</p>
                        <p>Bla bla ...</p>
                        <p>Bla bla ...</p>
                    </Modal>
                </div>
        )
    }
}
export default Home;