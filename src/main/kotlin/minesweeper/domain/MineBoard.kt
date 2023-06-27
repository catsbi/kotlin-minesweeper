package minesweeper.domain

import minesweeper.domain.finder.AdjacentPoints

class MineBoard(
    val area: Area,
    val lines: Lines,
    val coverLines: Lines = Lines.createCoverLines(area)
) {
    constructor(width: Int, height: Int, lines: Lines) : this(Area(width, height), lines)

    init {
        lines.flatten().forEach(::updateSymbol)
    }

    private fun updateSymbol(symbolPoint: SymbolPoint) =
        getAdjacentPoints(symbolPoint)
            .count { it.getSymbol() == SymbolType.MINE }
            .run(symbolPoint::updateSymbol)

    private fun getAdjacentPoints(point: SymbolPoint): List<SymbolPoint> =
        findPoint(x = point.x, y = point.y).let(::getAdjacentPointsOf)

    private fun getAdjacentPointsOf(point: SymbolPoint): List<SymbolPoint> =
        AdjacentPoints.values().map { it.movePoint(point) }
            .filter { it in lines }
            .map { findPoint(x = it.x, y = it.y) }

    private fun findPoint(x: Int, y: Int): SymbolPoint = lines.findPoint(Point(x = x, y = y))
}
