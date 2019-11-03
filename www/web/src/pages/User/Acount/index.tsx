import * as React from 'react';
import {inject, observer} from "mobx-react";
//
import {BaseProps, FormProps, RouteProps} from "@/types/props.interface";
import UserCenterLayout from "@/components/Layout/UserCenterLayout";
import {UserService} from "@common/services";

//
interface AccountPageProps extends FormProps, RouteProps, BaseProps {
}

/**
 * 个人信息编辑页面
 */
@inject('store')
@observer
export default class AccountPage extends React.Component<AccountPageProps> {

    async componentWillMount() {
        await UserService.profile().then(async (result) => {
            if (result.status === 1) {
                console.log(result);
            }
        });
    }

    render() {
        return (
            <UserCenterLayout>
                Home<br/>
            </UserCenterLayout>
        );
    }

}
