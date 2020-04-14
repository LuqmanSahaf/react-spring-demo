package io.github.luqmansahaf.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import io.github.luqmansahaf.demo.database.Connector;
import io.github.luqmansahaf.demo.entity.Dispatch;

import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DispatchRepositoryCustomImpl implements DispatchRepositoryCustom {

    @Autowired
    Connector connector;

    public Single<Dispatch> save(Dispatch dispatch) {
        return Single.create(emitter -> {
            var conn = connector.getConnection();
            Statement stmt;
            try {
                stmt = conn.createStatement();
                stmt.execute(dispatch.toSQLInsertString());
            } catch (SQLException e) {
                e.printStackTrace();
                emitter.onError(e);
            }
            emitter.onSuccess(dispatch);
        });
    }

    @Override
    public Single<List<Dispatch>> findAll() {
        return Single.create(emitter -> {
            List<Dispatch> dispatches = new ArrayList<>();
            var conn = connector.getConnection();
            Statement stmt;
            try {
                stmt = conn.createStatement();
                ResultSet rs;

                rs = stmt.executeQuery("SELECT * FROM dispatch");
                while ( rs.next() ) {
                    var dispatch = new Dispatch();
                    dispatch.setId(rs.getInt("id"));
                    dispatch.setName(rs.getString("name"));
                    dispatch.setColor(rs.getString("color"));
                    dispatch.setWeight(rs.getFloat("weight"));
                    dispatch.setDestination(rs.getString("destination"));

                    dispatches.add(dispatch);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                emitter.onError(e);
            }
            emitter.onSuccess(dispatches);
        });
    }
}
