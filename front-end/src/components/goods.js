import React, {Component} from 'react';
import '../styles/goods.css';


class Goods extends Component {
    State= ({
        handleFlag: false,
    })

    addGood = () => {
        this.setState({
            handleFlag: true,
        })
        URL = `http://localhost:8080/goods/${this.props.good.id}`
        fetch(URL, {
            method:"POST",
        }).then(Response => {
            if (Response.status === 200) {
                this.setState({
                    handleFlag: false,
                })
            }
            else {
                this.setState({
                    handleFlag: false,
                })
                Promise.reject();
            }
        });
        alert("添加成功！")
    }

    render() {
        let url = JSON.stringify(this.props.url);
        console.log(url)
        return (
            <section className="good">
                <img className="image" alt="goodspicture" src={this.props.good.imgUrl} ></img>
                       <div className="good-title">
                          <h3>{this.props.good.name}</h3>
                         <p>单价:{this.props.good.price}元/{this.props.good.goodunit}</p>
                     </div>
                    <button className='addButton' onChange={this.addGood}>+</button>
            </section>
        )
    }
}
export default Goods;