import React from "react";
//import { makeStyles } from "@material-ui/core/styles";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";

class SimpleTable extends React.Component {
  calculateCost({ weight, destination }) {
    const cost = typeof this.props.countries[destination] === 'undefined' ? '' : this.props.countries[destination].multiplier * weight;
    return Math.round((cost + Number.EPSILON) * 100) / 100;
  }

  render() {
    return (
      <TableContainer component={Paper}>
        <Table aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Receiver</TableCell>
              <TableCell align="right">Weight</TableCell>
              <TableCell align="right">Color</TableCell>
              <TableCell align="right">Shipping&nbsp;Cost</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {this.props.rows.map(row => (
              <TableRow key={row.id}>
                <TableCell component="th" scope="row">
                  {row.name}
                </TableCell>
                <TableCell align="right">{row.weight}{"  kilograms"}</TableCell>
                <TableCell
                  align="right"
                  style={{ backgroundColor: `rgb(${row.color})` }}
                />
                <TableCell align="right">{this.calculateCost(row)}{"  SEK"}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    );
  }
}

export default SimpleTable;
