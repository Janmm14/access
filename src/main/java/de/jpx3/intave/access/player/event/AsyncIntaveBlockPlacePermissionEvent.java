package de.jpx3.intave.access.player.event;

import de.jpx3.intave.access.IntaveEvent;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public final class AsyncIntaveBlockPlacePermissionEvent extends IntaveEvent implements Cancellable {
  private Player player;
  private World world;
  private boolean mainHand;
  private int blockX, blockY, blockZ;
  private int enumDirection;
  private Material type;
  private int variant;
  private boolean cancelled;

  protected AsyncIntaveBlockPlacePermissionEvent() {
  }

  public void copy(
    Player player,
    World world,
    boolean mainHand,
    int blockX, int blockY, int blockZ,
    int enumDirection,
    Material type, int variant
  ) {
    this.player = player;
    this.world = world;
    this.mainHand = mainHand;
    this.blockX = blockX;
    this.blockY = blockY;
    this.blockZ = blockZ;
    this.enumDirection = enumDirection;
    this.type = type;
    this.variant = variant;
    this.cancelled = false;
  }

  public Player player() {
    return player;
  }

  public World world() {
    return world;
  }

  public boolean isMainHand() {
    return mainHand;
  }

  public int blockX() {
    return blockX;
  }

  public int blockY() {
    return blockY;
  }

  public int blockZ() {
    return blockZ;
  }

  public int enumDirection() {
    return enumDirection;
  }

  public Material type() {
    return type;
  }

  public int variant() {
    return variant;
  }

  @Override
  public boolean isCancelled() {
    return cancelled;
  }

  @Override
  public void setCancelled(boolean cancelled) {
    this.cancelled = cancelled;
  }

  @Override
  public void referenceInvalidate() {
    player = null;
    world = null;
  }

  public static AsyncIntaveBlockPlacePermissionEvent empty() {
    return new AsyncIntaveBlockPlacePermissionEvent();
  }
}
