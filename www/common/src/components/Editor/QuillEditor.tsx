import * as React from 'react';
import ReactQuill from 'react-quill';
//
import './QuillEditor.less';

//
export interface QuillEditorProps {
    /**
     * 编辑器内容
     */
    content?: string
    /**
     * 回调函数，用于表单getFieldDecorator.getValueFromEvent来获取编辑器的内容
     */
    onChange?: Function
}

/**
 * QuillEditor
 *
 * https://zenoamaro.github.io/react-quill
 */
export default class QuillEditor extends React.Component<QuillEditorProps, any> {
    state = {
        content: '',
        modules: {
            toolbar: [
                [{'header': [1, 2, 3, 4, 5, false]}],
                ['bold', 'italic', 'underline', 'strike', 'blockquote'],
                [{'list': 'ordered'}, {'list': 'bullet'}, {'indent': '-1'}, {'indent': '+1'}],
                ['link', 'image'],
                ['clean']
            ],
        },
        formats: [
            'header',
            'bold', 'italic', 'underline', 'strike', 'blockquote',
            'list', 'bullet', 'indent',
            'link', 'image'
        ]
    };

    componentDidMount() {
        const {content = ''} = this.props;
        if (content) {
            this.setState({
                content: content
            })
        }
    }

    componentWillReceiveProps(nextProps: QuillEditorProps) {
        const {content = ''} = nextProps || this.props;
        if (content) {
            this.setState({
                content: content
            })
        }
    }

    handleChange = (content: string = '') => {
        const {onChange} = this.props;

        this.setState({
            content: content
        });

        if (onChange) {
            onChange(content.replace("<p><br></p>", ""))
        }
    };

    render() {
        return (
            <ReactQuill value={this.state.content}
                        defaultValue={this.state.content}
                        modules={this.state.modules}
                        formats={this.state.formats}
                        onChange={this.handleChange}/>
        );
    }
}
