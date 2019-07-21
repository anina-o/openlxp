import * as React from 'react';
import {Button, Card, Col, Form, Icon, Input, Row} from 'antd';
import * as intl from 'react-intl-universal';
import {inject, observer} from 'mobx-react';
//
import "./Login.less";
//
import environment from "@common/environments/environment";
import {UserService} from "@common/services";
import {handleValidationResult} from "@common/utils";

/**
 * 登录页面
 */
@inject('store')
@observer
class LoginPage extends React.Component<any, any> {
    /**
     * 登录处理
     */
    handleSubmit = (e: any) => {
        e.preventDefault();

        this.props.form.validateFields((err: any, values: any) => {
            if (!err) {
                UserService.login(values.username, values.password).then(async (result: any) => {
                    if (result.status === 1) {
                        // 更新登陆成功信息
                        await this.props.store.loginSuccess(result.data.token);
                        // 登陆成功后跳转
                        this.props.history.push('/');
                    } else {
                        // 处理后台验证结果
                        handleValidationResult(this, result);
                    }
                });
            }
        });
    };

    componentDidMount() {
        // 进入登陆页面清空所有之前登陆信息
        this.props.store.clear();
        // 如果测试环境初始开发账号方便调试
        if (!environment.production) {
            this.props.form.setFieldsValue({
                username: 'admin',
                password: '123456',
            });
        }
    };

    render() {
        const {getFieldDecorator} = this.props.form;

        return (
            <Row type="flex" align="middle">
                <Col span={6} offset={9}>
                    <Card className={'login-card'}
                          title={intl.get('user_page_login_title')}>
                        <Form onSubmit={this.handleSubmit}
                              className={'login-form'}>
                            <Form.Item>
                                {
                                    getFieldDecorator('username', {
                                        rules: [{
                                            message: intl.get("validation-required"),
                                            required: true,
                                        }],
                                    })(
                                        <Input prefix={<Icon type="user"/>}
                                               placeholder={intl.get("user_field_username")}/>
                                    )
                                }
                            </Form.Item>
                            <Form.Item>
                                {getFieldDecorator('password', {
                                    rules: [{
                                        message: intl.get("validation-required"),
                                        required: true,
                                    }],
                                })(
                                    <Input prefix={<Icon type="lock"/>}
                                           type="password"
                                           placeholder={intl.get("user_field_password")}/>
                                )}
                            </Form.Item>
                            <Form.Item>
                                <Button block type="primary" htmlType="submit">
                                    {intl.get("button_submit")}
                                </Button>
                            </Form.Item>
                        </Form>
                    </Card>
                </Col>
            </Row>
        )
    }
}

export default Form.create()(LoginPage);
