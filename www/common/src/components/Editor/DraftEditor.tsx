import * as React from 'react';
import {EditorState} from 'draft-js';
import BraftEditor from "braft-editor";
import 'braft-editor/dist/index.css'
//
import './DraftEditor.less';

/**
 * MediaPlayer
 *
 * https://github.com/margox/braft-editor
 */
class DraftEditor extends React.Component<any, any> {

    state = {
        editorState: BraftEditor.createEditorState(''),
        htmlContent: ''
    };

    async componentDidMount() {
        const htmlContent = '';
        this.setState({
            editorState: BraftEditor.createEditorState(htmlContent)
        })
    }

    handleEditorChange = (editorState: EditorState) => {
        this.setState({editorState})
    };

    render() {
        const {editorState} = this.state;
        return (
            <BraftEditor value={editorState}
                         onChange={this.handleEditorChange}
            />
        )
    }
}

export default DraftEditor;
