import * as React from 'react';
import {inject, observer} from "mobx-react";
//
import {BaseProps, FormProps, RouteProps} from "@/types/props.interface";
import UserCenterLayout from "@/components/Layout/UserCenterLayout";

//
interface AccountPageProps extends FormProps, RouteProps, BaseProps {
}

/**
 * 个人信息编辑页面
 */
@inject('store')
@observer
export default class AccountPage extends React.Component<AccountPageProps> {

    render() {
        return (
            <UserCenterLayout>
                Home<br/>
            </UserCenterLayout>
        );
    }

}
