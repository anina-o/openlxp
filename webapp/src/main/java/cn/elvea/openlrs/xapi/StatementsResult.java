package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class StatementsResult {
    /**
     *
     */
    private List<Statement> statements = new ArrayList<Statement>();
    /**
     * URL
     */
    private String more;
}
