import {RouteComponentProps} from "react-router";
import {FormComponentProps} from "antd/lib/form";
//
import GlobalStore from "../stores/GlobalStore";

// BaseProps
export interface BaseProps {
    store: GlobalStore
}

// RouteProps
export interface RouteProps extends RouteComponentProps<any, any> {
}

// FormProps
export interface FormProps extends FormComponentProps {
}
